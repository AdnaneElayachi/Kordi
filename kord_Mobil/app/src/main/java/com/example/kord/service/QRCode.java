package com.example.kord.service;

import com.example.kord.models.InformationUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode {
   private InformationUser Iuser;



    public String generateQRCode() throws WriterException {
        String content = "User: " + Iuser.getUser().getName() + "\n"
                + "Email: " + Iuser.getAdressesMail() + "\n"
                + "Phone: " + Iuser.getPhoneNumber() + "\n"
                + "Location: " + Iuser.getUserLocalization().getAdress();


        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);


        StringBuilder qrCode = new StringBuilder();
        for (int y = 0; y < bitMatrix.getHeight(); y++) {
            for (int x = 0; x < bitMatrix.getWidth(); x++) {
                qrCode.append(bitMatrix.get(x, y) ? "█" : " ");
            }
            qrCode.append("\n");
        }
        return qrCode.toString();
    }
}
