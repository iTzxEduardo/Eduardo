import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Exemplo de Stack')),
        body: Center(
          child: Stack(
            alignment: Alignment.center,
            children: [
              // Primeiro contêiner
              Container(
                width: 150,
                height: 150,
                color: Colors.red,
              ),
              // Segundo contêiner
              Container(
                width: 120,
                height: 120,
                color: Colors.green,
              ),
              // Texto sobreposto
              Text(
                'Camadas',
                style: TextStyle(
                  fontSize: 20,
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
