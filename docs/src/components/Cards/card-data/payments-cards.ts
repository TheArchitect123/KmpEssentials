import { CardProps } from '../Card';

const paymentsCards: CardProps[] = [
  {
    href: '/gpayments/fees.html',
    lightSVG: '/img/icons/buildanapp02.svg',
    darkSVG: '/img/icons/dark/buildanapp02.svg',
    header: 'Learn about Fees',
    summary: 'Click here to learn about how the gateway manages transaction fees',
  },
  {
    href: '/learn/station.html',
    lightSVG: '/img/icons/station/station.svg',
    darkSVG: '/img/icons/dark/station.svg',
    header: 'Get started with Station',
    summary: 'Create a Business wallet and Receive Crypto Payments from your Customers',
  },
  {
    href: 'https://github.com/TerraMystics/Terra.Unity.Package',
    lightSVG: '/img/icons/unity.svg',
    darkSVG: '/img/icons/unity.svg',
    header: 'Developing games with Unity3d?',
    summary: 'Empower your games with Terra Payments using our Unity SDK',
  },
  {
    href: 'https://www.nuget.org/packages/Terra.Net.OnChainPayments',
    lightSVG: '/img/icons/c_sharp.svg',
    darkSVG: '/img/icons/c_sharp.svg',
    header: 'Developing Apps for Microsoft C#?',
    summary: 'Easily integrate with Terra Payments via Nuget Package',
  },
  {
    href: 'https://pub.dev/packages/terra_dart_onchain_payments',
    lightSVG: '/img/icons/flutter.svg',
    darkSVG: '/img/icons/flutter.svg',
    header: 'For Flutter Developers',
    summary: 'Enhance your flutter app with Terra Payments',
  }
  ,
  {
    href: 'https://www.npmjs.com/package/terra.onchainpayments?activeTab=readme',
    lightSVG: '/img/icons/npm.svg',
    darkSVG: '/img/icons/npm.svg',
    header: 'Developing with NodeJS?',
    summary: 'Scale your product with Terra Payments for NodeJS',
  }, {
    href: 'https://github.com/TerraMystics/terra-swift',
    lightSVG: '/img/icons/swift.svg',
    darkSVG: '/img/icons/swift.svg',
    header: 'Developing for Swift & Apple?',
    summary: 'Scale your product with Terra Payments for the Native iOS & MacOS Systems',
  }
];

export default paymentsCards;
