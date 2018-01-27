package drodobytecom.mathexpression.presenter

import drodobytecom.mathexpression.Context
import drodobytecom.mathexpression.usecase.UserWritesExpressionUseCase
import drodobytecom.mathexpression.view.ExpressionView

class ExpressionPresenter extends Presenter<ExpressionView> {

    private UserWritesExpressionUseCase useCase

    ExpressionPresenter() {
        super(new ExpressionView())
        useCase = new UserWritesExpressionUseCase(Context.parser)
    }

    @Override
    void present(Closure end) {
        view.show null
        String written = view.getUserExpression()
        if (written.empty)
            end true
        else
            useCase.userExpression written, new UserWritesExpressionUseCase.Out() {
                @Override
                void provide(Integer result) {
                    view.showExpressionResult result
                    end false
                }

                @Override
                void provide(Exception e) {
                    view.showExpressionError e.message
                    end false
                }
            }
    }
}
