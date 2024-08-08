import React from 'react';
import { SocialLink, SocialLinkProps } from './SocialLink';

interface SocialLinkItems {
  socialLinks: SocialLinkProps[];
}

const SocialLinks: React.FC<SocialLinkItems> = ({ socialLinks }) => {
  return (
    <div className="social-links">
      {socialLinks.map((socialLink) => {
        return (
          <SocialLink
            href={socialLink.href}
            alt={socialLink.alt}
            lightSVG={socialLink.lightSVG}
            darkSVG={socialLink.darkSVG}
          />  
        )
      })}
    </div>
  )
}

export default SocialLinks;
