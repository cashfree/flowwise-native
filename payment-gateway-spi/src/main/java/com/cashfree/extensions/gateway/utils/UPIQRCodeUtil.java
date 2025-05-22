package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.exceptions.ErrorUPIQRCodeGeneration;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;

public class UPIQRCodeUtil {
  private static final int width = 300;
  private static final int height = 300;
  private static final String png = "png";

  public static String generateUpiQrCode(String upiLink) {
    try {
      // Generate QR Code BitMatrix
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter.encode(upiLink, BarcodeFormat.QR_CODE, width, height);

      // Convert BitMatrix to BufferedImage
      BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

      // Convert BufferedImage to Base64
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      ImageIO.write(qrImage, png, outputStream);
      byte[] qrBytes = outputStream.toByteArray();
      outputStream.close();

      return "data:image/png;base64," + Base64.getEncoder().encodeToString(qrBytes);
    } catch (WriterException | java.io.IOException e) {
      throw new ErrorUPIQRCodeGeneration("Error generating QR code");
    }
  }
}
