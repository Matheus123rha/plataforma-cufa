const oportunidadeService = require('./oportunidadeService');

class OportunidadeController {
    criar(req, res) {
        try {
            const novaOportunidade = oportunidadeService.salvar(req.body);
            return res.status(201).json(novaOportunidade);
        } catch (error) {
            return res.status(500).json({ error: error.message });
        }
    }

    atualizar(req, res) {
        try {
            const { id } = req.params;
            const dadosAtualizados = req.body;

            const oportunidadeAtualizada = oportunidadeService.atualizar(id, dadosAtualizados);

            if (!oportunidadeAtualizada) {
                return res.status(404).json({ mensagem: 'Oportunidade não encontrada' });
            }

            return res.status(200).json(oportunidadeAtualizada);
        } catch (error) {
            return res.status(500).json({ error: error.message });
        }
    }
}

module.exports = new OportunidadeController();