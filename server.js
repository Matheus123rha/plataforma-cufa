const express = require('express');
const aportunidadeController = require('./oportunidadeController');

const app = express();

app.use(express.json());
app.post('/oportunidades', aportunidadeController.criar);

app.put('/oportunidades/:id', aportunidadeController.atualizar);

const porta = 3000;
app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta}`);
});