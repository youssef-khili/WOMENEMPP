package tn.esprit.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.service.QRCodeGenerator;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
    private static String codeText;
    private static String codeTextx = "";
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";



    // http://localhost:8080/SpringMVC/qrcode/genrateQRCode/{codeText}/{width}/{height}
    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    @ResponseBody
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)

            throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
    }
}
