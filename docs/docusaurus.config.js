// @ts-check
const lightCodeTheme = require('./light.theme.js');
const darkCodeTheme = require('./dark.theme.js');
const theme = require('shiki/themes/material-default.json');
const { remarkCodeHike } = require('@code-hike/mdx');
/** @type {import('@docusaurus/types').Config} */
module.exports = async function config() {
  const math = (await import('remark-math')).default;
  const katex = (await import('rehype-katex')).default;
  return {
    title: 'Terra Docs',
    tagline: 'The official docs for the Terra blockchain',
    url: 'https://terradocs.money/',
    baseUrl: '/',
    onBrokenLinks: 'warn',
    onBrokenMarkdownLinks: 'warn',
    favicon: 'img/favicon.ico',
    organizationName: 'terra-mystics', // Usually your GitHub org/user name.
    projectName: 'docs', // Usually your repo name.
    i18n: {
      defaultLocale: 'en',
      locales: ['en'],
    },
    plugins: ['docusaurus-plugin-sass'],
    presets: [
      [
        'classic',
        /** @type {import('@docusaurus/preset-classic').Options} */
        ({
          docs: {
            beforeDefaultRemarkPlugins: [
              [
                remarkCodeHike,
                {
                  theme,
                  lineNumbers: true,
                  showCopyButton: true,
                  staticMediaQuery: 'not screen, (max-width: 768px)',
                },
              ],
              math,
            ],
            rehypePlugins: [katex],
            sidebarPath: require.resolve('./sidebars.js'),
            routeBasePath: '/', // Serve the docs at the site's root
            // Please change this to your repo.
            // Remove this to remove the "edit this page" links.
          },
          blog: false,
          theme: {
            customCss: [
              require.resolve('@code-hike/mdx/styles.css'),
              require.resolve('./src/styles/main.scss'),
              require.resolve('katex/dist/katex.min.css'),
            ],
          },
        }),
      ],
      ['docusaurus-plugin-matomo', {}],
      [
        'redocusaurus',
        {
          specs: [
            {
              id: 'complete',
              spec: 'https://phoenix-lcd.terra.dev/swagger/swagger.yaml',
              route: '/api/',
            },
          ],
          theme: {
            primaryColor: '#1890ff',
          },
        },
      ],
    ],
    themes: ['mdx-v2'],
    themeConfig:
      /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
      ({
        image: 'img/favicon.png',
        docs: {
          sidebar: {
            hideable: false,
            autoCollapseCategories: false,
          },
        },
        algolia: {
          appId: 'Z6EOSIPZCY',
          apiKey: '532be63cd62ff0e733ccd844e799e8bb',
          indexName: 'terra-project',
          contextualSearch: true,
        },
        navbar: {
          title: '',
          logo: {
            alt: 'Terra Docs',
            src: 'img/logo_light.svg',
            srcDark: 'img/logo_dark.svg',
          },
          items: [
            {
              href: 'https://terramystics.money/gpayments/gateway', //front-end URL
              position: 'right',
              label: 'terramystics.money',
              className: 'header-terra-link',
              'aria-label': 'TerraMystics',
            },
            {
              href: 'https://github.com/TerraMystics',
              position: 'right',
              className: 'header-github-link',
              'aria-label': 'GitHub repository',
            },
            {
              href: 'https://twitter.com/realArchitectDG',
              position: 'right',
              className: 'header-twitter-link',
              'aria-label': 'Twitter Profile',
            },
          ],
        },
        footer: {},
        prism: {
          theme: lightCodeTheme,
          darkTheme: darkCodeTheme,
        },
        matomo: {
          matomoUrl: 'https://terradocs.matomo.cloud/',
          siteId: '2',
          phpLoader: 'matomo.php',
          jsLoader: 'matomo.js',
        },
      }),
    stylesheets: [
      {
        href: 'https://cdn.jsdelivr.net/npm/katex@0.13.24/dist/katex.min.css',
        type: 'text/css',
        integrity:
          'sha384-odtC+0UGzzFL/6PNoE8rX/SPcQDXBJ+uRepguP4QkPCm2LBxH3FA3y+fKSiJ+AmM',
        crossorigin: 'anonymous',
      },
    ],
  };
};
