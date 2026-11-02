const oportunidadesCadastradas = []

class OportunidadeService {
  salvar(dadosOportunidade) {
    const novaOportunidade = {
        id: oportunidadesCadastradas.length + 1,
        ...dadosOportunidade
    }
    oportunidadesCadastradas.push(novaOportunidade)
    return novaOportunidade
  };
}

module.exports = new OportunidadeService()

