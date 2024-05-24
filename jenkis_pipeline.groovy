// Skip nos stages que não foram selecionados na construção do job
import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

buildnumber = currentBuild.number

JOBNAME = env.JOB_NAME
VM_NODE = env.Maquina

// Aborta o step caso passe desse tempo (minutos)
env.TIMEOUT = 10

if (env.UF == "") {
  env.UF = "MG"
  env.DDD = "31"
}

try {
  node("$VM_NODE") {
    // Limpeza do diretorio de evidencias
    bat "D:/Jenkins/bat/cleanRegressaoCRC.bat $JOBNAME"
  }
} catch (all) {
    echo all.toString()
}


def Regressao(String testName, String scenarioName, String nd) {

  try {
    stage(scenarioName) {
      timeout(time: env.TIMEOUT, unit: 'MINUTES') {
        node(nd) {
          if (env.Cenarios.contains(scenarioName) || env.Execucao.equals("Tudo")) {
            //withMaven {
              bat "D:/Jenkins/bat/RegressaoSiebelPos_CRC_2022.bat $testName $AMBIENTE $JOBNAME \"$scenarioName\" ${env.NODE_NAME} ${buildnumber}" 
            //}
            archiveArtifacts '*.zip'
          } else {
            Utils.markStageSkippedForConditional(scenarioName)
            archiveArtifacts '*.zip'
          }
        }
      }
    }
  } catch (all) {
    node(nd) {
    archiveArtifacts '*.zip'
    }
  }
}


Regressao('login', 'Teste - Login', "$VM_NODE")
Regressao('CY0001', 'CY0001 - Pesquisar dados do cliente (física, jurídica, estrangeira)', "$VM_NODE")
Regressao('CY0002', 'CY0002 - Fluxos Alternativo – Consulta dados do Cliente', "$VM_NODE")
Regressao('CY0003', 'CY0003 - Fluxo de Exceção – CPFCNPJ com formato inválido', "$VM_NODE")
Regressao('CY0004', 'CY0004 - Fluxo de Exceção – Todos os campos em branco', "$VM_NODE")
Regressao('CY0005', 'CY0005 - Fluxo de Exceção – Cliente não encontrado e consultor possui perfil para criação de cliente', "$VM_NODE")
Regressao('CY0006', 'CY0006 - Testar Exibição de Tela Inicial Acesso', "$VM_NODE")
Regressao('CY0007', 'CY0007 - Manter Solicitações de Serviço - FE - CRC', "$VM_NODE")
Regressao('CY0008', 'CY0008 - Fluxo Alternativo – Consultor deseja criar um novo atendimento para um Cliente Potencial a partir da tela de Cliente Potencial', "$VM_NODE")
Regressao('CY0009', 'CY0009 - Consultar Faturas - Cliente PF', "$VM_NODE")
Regressao('CY0011', 'CY0011 - Consultar Parcelamentos - Cliente PF', "$VM_NODE")
Regressao('CY0012', 'CY0012 - Criação de Interação Manual', "$VM_NODE")
Regressao('CY0013', 'CY0013 - Fluxo Alternativo – Consultor deseja fechar uma Interação Manual', "$VM_NODE")
Regressao('CY0014', 'CY0014 - Fluxo de Exceção – Já existe uma interação manual aberta para o acesso', "$VM_NODE")
Regressao('CY0015', 'CY0015 - Fluxo de Exceção – Já existe uma interação manual aberta para o cliente', "$VM_NODE")
Regressao('CY0016', 'CY0016 - Consultar Histórico de Cobrança', "$VM_NODE")
Regressao('CY0017', 'CY0017 - Fluxo Alternativo – Consultor deseja pesquisar um período diferente do default', "$VM_NODE")
Regressao('CY0018', 'CY0018 - Consultar PagamentosCliente PF ou PJ', "$VM_NODE")
Regressao('CY0020', 'CY0020 - Fluxo de Alteração – Atendimento é de alteração de Forma de Pagamento.', "$VM_NODE")
Regressao('CY0021', 'CY0021 - Fluxo Alternativo – Consultor acessa tela inicial para visualização do perfil de faturamento.', "$VM_NODE")
Regressao('CY0021_Alternativo', 'CY0021 - SiebelPos_CRC – Consulta Atendimento BO', "$VM_NODE")
Regressao('CY0022', 'CY0022 - Fluxo Alternativo – Consultor deseja adicionar novo endereço de recebimento da fatura', "$VM_NODE")
Regressao('CY0023', 'CY0023 - Fluxo Alternativo – Atendimento é de alteração de Data de Vencimento', "$VM_NODE")
Regressao('CY0025', 'CY0025 CRC Consultor deseja excluir um endereço na tela de alteração cadastral', "$VM_NODE")
Regressao('CY0026', 'CY0026 - Fluxo Alternativo – Exibe tela com informações do cliente PJ', "$VM_NODE")
Regressao('CY0027', 'CY0027 - Fluxo Alternativo – Consultor deseja alterar endereço do cliente', "$VM_NODE")
Regressao('CY0028_Alternativo', 'CY0028 - Fluxo Alternativo – Consultor desiste da alteração.', "$VM_NODE")
Regressao('CY0028', 'CY0028 - SiebelPos_CRC – Consultar Histórico do Clarify', "$VM_NODE")
Regressao('CY0029', 'CY0029 - SiebelPos_CRC - Consultar Ordens de Venda no SAP', "$VM_NODE")
Regressao('CY0029_Alternativo', ' CY0029 - Fluxo Alternativo – Consultor deseja alterar contato do clienteConsultor deseja alterar dados de um Consultor deseja excluir um contato', "$VM_NODE")
Regressao('CY0030', 'CY0030 - Fluxo Alternativo – Consultor deseja visualizar documentos do cliente', "$VM_NODE")
Regressao('CY0031', 'CY0031 - Fluxo Alternativo – Consultor anexa documento ao cliente', "$VM_NODE")
Regressao('CY0032', 'CY0032 - Fluxo Alternativo – Consultor deleta anexo do cliente', "$VM_NODE")
Regressao('CY0033', 'CY0033 - Fluxo Alternativo – Consultor deseja identificar o cliente como Obrigações Rurais', "$VM_NODE")
Regressao('CY0034', 'CY0034 - Fluxo Alternativo – Usuário deseja alterar o tipo de deficiência do cliente', "$VM_NODE")
Regressao('CY0035', 'CY0035 - Fluxo Alternativo – Consultor deseja solicitar uma correção cadastral à área de Cadastro', "$VM_NODE")
Regressao('CY0038', 'CY0038 - Fluxo de Exceção – Campo e-mail preenchido com formato inválido', "$VM_NODE")
Regressao('CY0039', 'CY0039 - Fluxo de Exceção – Campos requeridos não estão preenchidos', "$VM_NODE")
Regressao('CY0040', 'CY0040 - Fluxo de Exceção – Ocorre falha na entrega mensagem ao barramento (MW)', "$VM_NODE")
Regressao('CY0045', 'CY0045 - Fluxo Alternativo – Cliente desiste da Inclusão', "$VM_NODE")
Regressao('CY0046', 'CY0046 - Fluxo Alternativo – Consultor acessa a tela a partir do hiperlink no nome de um cliente potencial da base', "$VM_NODE")
Regressao('CY0048', 'CY0048 - Fluxo de Exceção – CPF/CNPJ com formato inválido', "$VM_NODE")
Regressao('CY0066_LIVE', 'CY0066 - Administrar CEPs WTTX', "$VM_NODE")
Regressao('CY0068', 'CY0068 - Pesquisar Protocolo+Pesquisar Protocolo [CDU0035]Fluxo Alternativo – Obter mais detalhes do acesso+Pesquisar Protocolo [CDU0035]Fluxo Alternativo – Obter mais detalhes do cliente', "$VM_NODE")
Regressao('CY0069', 'CY0069 - Fluxo de Exceção - Protocolo não encontrado', "$VM_NODE")
Regressao('CY0071', 'CY0072 - Fluxo Alternativo – Consultor seleciona botão “Encaminhar”', "$VM_NODE")
Regressao('CY0072', 'CY0071 - Fluxo Alternativo – Consultor está na Tela de Clientes', "$VM_NODE")
Regressao('CY0073_Alternativo', 'CY0073 - Fluxo Alternativo – Consultor seleciona botão “Fechar em Linha”', "$VM_NODE")
Regressao('CY0073', 'CY0073 - Fluxo Alternativo – Consultor deseja consultar detalhes da Interação', "$VM_NODE")
Regressao('CY0074', 'CY0074 - Fluxo Alternativo – Consultor deseja cancelar o atendimento', "$VM_NODE")
Regressao('CY0074_Alternativo', 'CY0074 - Fluxo Alternativo – Consultor deseja visualizar detalhes da Interação de Vendas', "$VM_NODE")
Regressao('CY0075', 'CY0075 - Solicitar Envio de Correspondência - Cliente PF+Fluxo Alternativo – Tripleta invalida para atendimaento desejado', "$VM_NODE")
Regressao('CY0076', 'CY0076 - Fluxo Alternativo – Consultor seleciona o canal de envio de correspondência por carta', "$VM_NODE")
Regressao('CY0077', 'CY0077 - Fluxo Alternativo – Consultor seleciona o canal de envio de correspondência por SMS.', "$VM_NODE")
Regressao('CY0077_Alternativo', 'CY0077 - Fluxo Alternativo – Encaminha atividade para área parceira.', "$VM_NODE")
Regressao('CY0078', 'CY0078 - Fluxo Alternativo – Consultor seleciona o canal de envio de correspondência por telefone', "$VM_NODE")
Regressao('CY0079', 'CY0079 - Solicitar Reset de Senha', "$VM_NODE")
Regressao('CY0085', 'CY0085 - Manter Solicitações de Serviço - BO', "$VM_NODE")
Regressao('CY0086', 'CY0086 - Pesquisar Acesso', "$VM_NODE")
Regressao('CY0087', 'CY0087 - Fluxo Alternativo – Consultor deseja Reencaminhar o atendimento manualmente', "$VM_NODE")
Regressao('CY0088', 'CY0088 - Atribuir Atendimento em LoteFluxo Alternativo – Supervisor/Coordenador deseja fazer uma pesquisa por consultores', "$VM_NODE")
Regressao('CY0088_Alternativo', 'CY0088 - Fluxo Alternativo – Consultor deseja pesquisar utilizando o CustCode do Acesso', "$VM_NODE")
Regressao('CY0089', 'CY0089 - Fluxo Alternativo – Consultor deseja pesquisar utilizando o CustomerID do Acesso', "$VM_NODE")
Regressao('CY0090', 'CY0090 - Fluxo Alternativo – Consultor deseja pesquisar utilizando o ContractID do Acesso', "$VM_NODE")
Regressao('CY0093', 'CY0093 - Fluxo de Exceção – Acesso está cancelado no Pós e Ativo no Pré', "$VM_NODE")
Regressao('CY0094', 'CY0094 - Fluxo de Exceção – Acesso está cancelado no Pós e Cancelado no Pré', "$VM_NODE")
Regressao('CY0095', 'CY0095 - Fluxo de Exceção – Acesso está cancelado no Pós e não existe no Pré', "$VM_NODE")
Regressao('CY0097', 'CY0097 - Fluxo de Exceção – Acesso está ativo no Pré e não existe no Pós', "$VM_NODE")
Regressao('CY0098', 'CY0098 - Consultar Informações do AcessoConsultor deseja visualizar informação de Não PerturbeConsultor deseja consultar IMSI...', "$VM_NODE")
Regressao('CY0099', 'CY0099 - Consultar Histórico de Portabilidade', "$VM_NODE")
Regressao('CY0100', 'CY0100 - Consultar Fidelização -CRC', "$VM_NODE")
Regressao('CY0102', 'CY0102 - Fluxo Alternativo – Consultor deseja interromper uma fidelização', "$VM_NODE")
Regressao('CY0103', 'CY0103 - Fluxo Alternativo – Consultor deseja isentar uma fidelização', "$VM_NODE")
Regressao('CY0104', 'CY0104 - Fluxo Alternativo – Consultor deseja realizar a simulação de multa por quebra de fidelização para troca de plano', "$VM_NODE")
Regressao('CY0105', 'CY0105 - Fluxo de Exceção – Número de telefone não possui nenhum item de fidelização', "$VM_NODE")
Regressao('CY0106', 'CY0106 - Fluxo de Exceção – Data de Início superior a Data de Fim', "$VM_NODE")
Regressao('CY0112', 'CY0112 - Consultar Bônus Recebidos', "$VM_NODE")
Regressao('CY0116', 'CY0116 - Fluxo Alternativo – Cliente deseja reparcelar parcelamento já existente', "$VM_NODE")
Regressao('CY0117', 'CY0117 - SiebelPos_CRC_ConsultaEstruturaMaster', "$VM_NODE")
Regressao('CY0118', 'CY0118 - SiebelPos_CRC_ConsultaEstruturaDependente', "$VM_NODE")
Regressao('CY0120', 'CY0120 - Solicitar Antecipação de Parcelas - CRC', "$VM_NODE")
Regressao('CY0122', 'CY0122 - Consultar Acessos do Cliente -CRC', "$VM_NODE")
Regressao('CY0124', 'CY0124 - Consultar Serviços e Promoções -CRC', "$VM_NODE")
Regressao('CY0124_Extra', 'CY0124 - Extra - Aceite de Oferta (Retenção)', "$VM_NODE")
Regressao('CY0126', 'CY0126 - Consultar Histórico dos Clientes do Acesso', "$VM_NODE")
Regressao('CY0129', 'CY0129 - Consultar Contatos do Acesso', "$VM_NODE")
Regressao('CY0130', 'CY0130 - Consultar Contatos do Cliente -CRC', "$VM_NODE")
Regressao('CY0131', 'CY0131 - Envio Código de Barras por SMS – Via ECM', "$VM_NODE")
Regressao('CY0131_Extra', 'CY0131 - Extra - Troca de Plano Master -> Master', "$VM_NODE")
Regressao('CY0132_Extra', 'CY0132 - Extra - Modificar Acesso Master (Troca de Plano Master -> Master)', "$VM_NODE")
Regressao('CY0132', 'CY0132 - Fluxo Alternativo – Consultor seleciona Perfil de Fatura', "$VM_NODE")
Regressao('CY0133', 'CY0133 - Bloquear - Desbloquear Aparelho – CRC', "$VM_NODE")
Regressao('CY0145', 'CY0145 - Fluxo de Exceção – Bloqueio em andamento no HPERM (ainda não confirmado pelo EIR)', "$VM_NODE")
Regressao('CY0146', 'CY0146 - Fluxo de Exceção – Desbloqueio em andamento no HPERM (ainda não confirmado pelo EIR)', "$VM_NODE")
Regressao('CY0147', 'CY0147 - Manter Solicitação de Portabilidade -CRC)', "$VM_NODE")
Regressao('CY0152', 'CY0152 - Consultar Trilha de Auditoria –Cliente -CRC', "$VM_NODE")
Regressao('CY00153_LIVE', ' CY0153 - Fluxo de Exceção – SGF retorna inviabilidade no endereço', "$VM_NODE")
Regressao('CY0154', 'CY0154 - Fluxo Alternativo – Consultor deseja visualizar Audit Trail de Contatos', "$VM_NODE")
Regressao('CY0156', 'CY0156 - Consultar Trilha de Auditoria –Perfil de Faturamento -CRC', "$VM_NODE")
Regressao('CY0158', 'CY0158 - Consultar RTD', "$VM_NODE")
Regressao('CY0164', 'CY0164 - Consultar Tickler - Campos de datas com preenchimento inválido', "$VM_NODE")
Regressao('CY0166', 'CY0166 - Solicitar Informação de Relatório Detalhado – CRC+Consultar Solicitações de Relatório Detalhado - CRC', "$VM_NODE")
Regressao('CY0169', 'CY0169 - Solicitação de Envio de Relatório Detalhado – CRC', "$VM_NODE")
Regressao('CY0172', 'CY0172 - Consulta SERVCEL - CRC', "$VM_NODE")
Regressao('CY0173', 'CY0173 - Fluxo Alternativo – Consultor deseja realizar pesquisa por data', "$VM_NODE")
Regressao('CY0186', 'CY0186 -Solicitar Segunda Via de Sumário Contrato', "$VM_NODE")
Regressao('CY0187', 'CY0187 - Consulta de Histórico de Variações Consultor', "$VM_NODE")
Regressao('CY0188', 'CY0188 - Consultar Notificação de Consumo - CRC', "$VM_NODE")
Regressao('CY0190', 'CY0190 -  Troca ChipPF - Revenda - PósPago - HLR do TIM Chip diferente do HLR do DDD do cliente', "$VM_NODE")
Regressao('CY0190_Alternativo', 'CY0190 - Fluxo Alternativo – Consultor deseja Contratar ou Recontratar Pacote Adicional', "$VM_NODE")
Regressao('CY0194', 'CY0194 - Consultar Consumo de Voz - CRC', "$VM_NODE")
Regressao('CY0195', 'CY0195 - Fluxo Alternativo – Acesso do Tipo Controle', "$VM_NODE")
Regressao('CY0197', 'CY0197 - Manutenção de Créditos e Encargos (OCCs)', "$VM_NODE")
Regressao('CY0198', 'CY0198 - Fluxo Alternativo – Consultor deseja Consultar OCCs', "$VM_NODE")
Regressao('CY0199', 'CY0199 - Fluxo Alternativo – Consultor deseja Excluir OCCs', "$VM_NODE")
Regressao('CY0200', 'CY0200 - Consultar Dados do Aparelho - CRC', "$VM_NODE")
Regressao('CY0201', 'CY0201 - Fluxo Alternativo – Cliente informa o IMEI, que não consta na lista, a ser consultado', "$VM_NODE")
Regressao('CY0204', 'CY0204 - Fluxo Alternativo - Consultor deseja cancelar cadastro', "$VM_NODE")
Regressao('CY0203', 'CY0203 - Fluxo Alternativo – Consultor deseja consultar viabilidade do endereço para ativação TIM Live CEP contempla mais de um bairro CEP válido para toda a cidade CEP não encontrado', "$VM_NODE")
Regressao('CY0205', 'CY0205 - Fluxo Alternativo – Consultor deseja selecionaralterar o tipo de deficiência do cliente', "$VM_NODE")
Regressao('CY0206', 'CY0206 - Fluxo Alternativo – Consultor deseja anexar arquivo ao cliente', "$VM_NODE")
Regressao('CY0207', 'CY0207 - Fluxo Alternativo – Consultor está cadastrando um cliente Pessoa Jurídica + Manter Contatos - CRC [CDU0027]', "$VM_NODE")
Regressao('CY0220', 'CY0220 - Exibir Tela Inicial Cliente (CRC)', "$VM_NODE")
Regressao('CY0224', 'CY0224 - Fluxo de Exceção – Campos requeridos não estão preenchidos', "$VM_NODE")
Regressao('CY0228', 'CY0228 - Histórico de Dunning', "$VM_NODE")
Regressao('CY0230', 'CY0230 - Fluxo Alternativo – Consultor deseja realizar a pesquisa por CPF/CNPJ', "$VM_NODE")
Regressao('CY0232', 'CY0232 - Realizar Correção Cadastral', "$VM_NODE")
Regressao('CY0233', 'CY0233 - Fluxo Alternativo – Consultor deseja visualizar documentos (podem existir ou não) do cliente', "$VM_NODE")
Regressao('CY0234', 'CY0234 - Fluxo Alternativo – Consultor anexa documento ao cliente', "$VM_NODE")
Regressao('CY0235', 'CY0235 - Fluxo de Exceção – O CPF já existe na base', "$VM_NODE")
Regressao('CY0244', 'CY0244 - Fluxo de Exceção – Data de solicitação de 2ª via de fatura é superior a 5 dias do vencimento', "$VM_NODE")
Regressao('CY0255', 'CY0255 - Exibir Tela Inicial Retenção + Verificar Ofertas (NBA) + CDU0210 – Verificar Ofertas (NBA) Fluxo Alternativo – Cliente não aceita a oferta sugerida', "$VM_NODE")
Regressao('CY0256', 'CY0256 - Consultar Trilha de Auditoria – SR - CRC', "$VM_NODE")
Regressao('CY0257', 'CY0257 - Consultar Links de Outros Sistemas', "$VM_NODE")
Regressao('CY0260', 'CY0260 - Selecionar Endereço de Área Acesso Fixo + Fluxo de Exceção – Sistema identifica que o endereço de destino não é do mesmo DDD que o endereço de origem', "$VM_NODE")
Regressao('CY0261', 'CY0261 - Selecionar Número do Acesso+Fluxo Alternativo – Consultor deseja pesquisar número utilizando máscara', "$VM_NODE")
Regressao('CY0262', 'CY0262 - Selecionar Plano do acesso', "$VM_NODE")
Regressao('CY0263', 'CY0263 - Desbloquear Acesso - CRC', "$VM_NODE")
Regressao('CY0267', 'CY0267 - Modificar Acesso – CRC', "$VM_NODE")
Regressao('CY0272', 'CY0272 - Fechar Ordem – CRC', "$VM_NODE")
Regressao('CY0273', 'CY0273 - Selecionar Perfil de Fatura - CRC', "$VM_NODE")
Regressao('CY0274', 'CY0274 - Fluxo Alternativo – Usuário deseja criar um novo perfil de fatura', "$VM_NODE")
Regressao('CY0275', 'CY0275 - Fluxo Alternativo – Acesso selecionado possui plano Família', "$VM_NODE")
Regressao('CY0278', 'CY0278 - Selecionar Pacote + Fluxo Alternativo – Consultor deseja desativar um pacote', "$VM_NODE")
Regressao('CY0280', 'CY0280 - Manter Ordem - CRC', "$VM_NODE")
Regressao('CY0283', 'CY0283 - Selecionar Descontos + Fluxo Alternativo – Consultor deseja remover um desconto', "$VM_NODE")
Regressao('CY0285', 'CY0285 - Fluxo Alternativo – Consultor deseja selecionar um desconto fidelizado', "$VM_NODE")
Regressao('CY0286', 'CY0286 - Selecionar serviços do acesso+Fluxo Alternativo – Consultor deseja desativar/remover um serviço', "$VM_NODE")
Regressao('CY0287', 'CY0287 - Fluxo de Exceção - Existe conflito de produtos no configurador', "$VM_NODE")
Regressao('CY0294', 'CY0294 - Troca de SIM Card do Acesso – CRC', "$VM_NODE")
Regressao('CY0296', 'CY0296 - Selecionar Endereço de Entrega', "$VM_NODE")
Regressao('CY0305', 'CY0305 - Selecionar Aparelho e Chip para Delivery + Fluxo Alternativo – Consultor deseja selecionar delivery de Tim Chip', "$VM_NODE")
Regressao('CY0312', 'CY0312 - Envio de Correspondência de Ordem', "$VM_NODE")
Regressao('CY0313', 'CY0313 - Fluxo Alternativo – Forma de envio padrão da tripleta é Carta', "$VM_NODE")
Regressao('CY0316', 'CY0316 - Fluxo Alternativo – Consultor deseja excluir contato do acesso cadastrado', "$VM_NODE")
Regressao('CY0317', 'CY0317 - Fluxo Alternativo – Consultor clica em “Excluir” no applet “Ações do Grupo Família”', "$VM_NODE")
Regressao('CY0318', 'CY0318 - Criar Ordem - CRC - Modificar Acesso', "$VM_NODE")
Regressao('CY0321', 'CY0321 - Fluxo Alternativo – Consultor deseja consultar ordens do cliente', "$VM_NODE")
Regressao('CY0325', 'CY0325 - Fluxo Alternativo – Troca de titularidade é por óbito', "$VM_NODE")
Regressao('CY0326', 'CY0326 - Consultar Histórico de Contestação', "$VM_NODE")
Regressao('CY0327', 'CY0327 - Solicitar 2ª Via de Recibo de Arrecadação+Fluxo Alternativo – Consultor decide realizar uma pesquisa', "$VM_NODE")
Regressao('CY0329', 'CY0329 - Consultar Estoque', "$VM_NODE")
Regressao('CY0390', 'CY0390 - Exibir dados da dívida do cliente', "$VM_NODE")