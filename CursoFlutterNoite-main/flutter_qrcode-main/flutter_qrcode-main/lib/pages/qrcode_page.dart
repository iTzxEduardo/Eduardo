import 'package:flutter/material.dart';
import 'package:qr_flutter/qr_flutter.dart';


class QRCodeGeneratorPage extends StatelessWidget {
  final String data; // Dados que serão codificados no QR code

  const QRCodeGeneratorPage({Key? key, required this.data}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Gerador de QR Code'),
      ),
      body: Center(
        child: QrImage(
          data: data, // Dados a serem codificados
          version: QrVersions.auto,
          size: 200.0, // Tamanho do QR code
        ),
      ),
    );
  }
}
