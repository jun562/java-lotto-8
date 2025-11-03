package controller;

import service.LottoService;
import view.InputView;
import view.OutputView;
import view.Parser;
import view.Validator;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmountWithRetry();

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        OutputView.printLottoCount(lottoCount);
    }

    private int getPurchaseAmountWithRetry() {
        OutputView.printPurchaseAmountPrompt();

        while (true) {
            try {
                return processPurchaseAmount();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    /**
     * 사용자 입력 파싱 및 검증 헬퍼 메서드
     */
    private int processPurchaseAmount() {
        String input = InputView.getPurchaseAmount();
        int purchaseAmount = Parser.parseStringToInteger(input);
        Validator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
}
