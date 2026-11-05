const oportunidadesCadastradas = []

class OportunidadeService {
  salva(dadosoportunidade) {
    const novaOportunidade = {
      id: oportunidadesCadastradas.length + 1,
      ...dadosoportunidade
    }
    oportunidadesCadastradas.push(novaOportunidade)
    return novaOportunidade
  }

  atualizar(id, dadosAtualizados) {
    const oportunidade = oportunidadesCadastradas.find(opt => opt.id === Number(id))
    if (!oportunidade) {
      return null
    }
    Object.assign(oportunidade, dadosAtualizados)
    return oportunidade
  }
}

module.exports = new OportunidadeService()