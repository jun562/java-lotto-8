package lotto;

import controller.LottoController;
import domain.LottoGenerator;
import service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(lottoGenerator);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();

    }
}
