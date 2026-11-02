const oportunidadeService = require('./oportunidadeService');

class OportunidadeController {
    criar(req, res) {
        try{
            const dados = req.body;
            const oportunidadeSalva = oportunidadeService.criar(dados);
            return res.status(201).json(oportunidadeSalva);
        } catch (error) {
            return res.status(400).json({ error: error.message });
        }
    }
}

module.exports = new OportunidadeController();