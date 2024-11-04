import 'package:flutter/material.dart';
import 'package:flutter_qrcode/pages/qrcode_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'App QR Code',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const HomePage(), // Página inicial
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Página Principal'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            // Navegar para a página de QR Code
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => const QRCodeGeneratorPage(data: 'https://www.exemplo.com'), // Modifique os dados conforme necessário
              ),
            );
          },
          child: const Text('Gerar QR Code'),
        ),
      ),
    );
  }
}
