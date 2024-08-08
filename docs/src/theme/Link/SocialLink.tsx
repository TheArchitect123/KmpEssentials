import React from 'react';
import ThemedImage from '@theme/ThemedImage';

export interface SocialLinkProps {
  href: string;
  alt: string;
  lightSVG: string;
  darkSVG: string;
}

export const SocialLink: React.FC<SocialLinkProps> = ({
  href, alt, lightSVG, darkSVG
}) => {
  return (
    <a className='social-link' href={href}>
      <ThemedImage
        className='social-image'
        alt={alt}
        sources={{
          light: lightSVG,
          dark: darkSVG,
        }}
      />
    </a>
  )
}
