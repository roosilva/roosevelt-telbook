import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Página Inicial',
    icon: 'nb-home',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'Funcionalidades [MENU]',
    group: true,
  },
  {
    title: 'Consumer',
    icon: 'nb-person',
    children: [
      {
        title: 'Dados de Satisfação',
        link: '/pages/consumer/dados-satisfacao',
      },
      {
        title: 'Questionário',
        link: '/pages/consumer/questionario-satisfacao',
      },
    ],
  },
  {
    title: 'Admin',
    icon: 'nb-gear',
    children: [
      {
        title: 'Upload - CSV',
        link: '/pages/admin/upload-telefonia',
      }, {
        title: 'Configuração',
        link: '/pages/admin/configuracao',
      },
    ],
  },
  {
    title: 'Agent',
    icon: 'nb-cloudy',
    children: [
      {
        title: 'Cadastro de Agent',
        link: '/pages/agent/cadastro-agent',
      },
      {
        title: 'Endereços das APIs',
        link: '/pages/agent/endereco-apis',
      },
    ],
  },
];
