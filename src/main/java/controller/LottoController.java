package controller;

import domain.Lotto;
import domain.LottoResult;
import domain.LottoWallet;
import domain.WinningLotto;
import java.util.List;
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
        LottoWallet lottoWallet = lottoService.generateLottoWallet(lottoCount);
        
        OutputView.printLottoCount(lottoCount);
        OutputView.printPurchasedLottos(lottoWallet);

        WinningLotto winningLotto = getWinningLottoWithRetry();
        LottoResult result = lottoService.calculateResult(lottoWallet, winningLotto, purchaseAmount);
        OutputView.printLottoResult(result);
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

    private WinningLotto getWinningLottoWithRetry() {
        Lotto winningNumbers = getWinningNumbersWithRetry();
        int bonusNumber = getBonusNumberWithRetry(winningNumbers);
        return lottoService.createWinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto getWinningNumbersWithRetry() {
        OutputView.printWinningNumbersPrompt();
        while (true) {
            try {
                String input = InputView.getWinningNumbers();
                List<Integer> numbers = Parser.parseStringToList(input);
                Validator.validateWinningLotto(numbers);

                return lottoService.createLotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int getBonusNumberWithRetry(Lotto winningNumbers) {
        OutputView.printBonusNumberPrompt();
        while (true) {
            try {
                String input = InputView.getBonusNumber();
                int bonusNumber = Parser.parseStringToInteger(input);

                Validator.validateBonusNumber(bonusNumber, winningNumbers.getNumbers());

                return bonusNumber;
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
