const express = require('express');
const aportunidadeController = require('./oportunidadeController');

const app = express();

app.use(express.json());
app.post('/oportunidades', aportunidadeController.criar);
app.get('/oportunidades', (req, res) => res.status(201).json({ status: "Back-end da CUFA funcionando!", codigo: 201 }));

const porta = 3000;
app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`);
})