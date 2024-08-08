import React from 'react';

export interface HyperlinkProps {
  href: string;
  innerHTML: string;
}

export const Hyperlink: React.FC<HyperlinkProps> = ({ href, innerHTML }) => {
  return (
    <a className='hyperlink' href={href}>
      {innerHTML}
    </a>
  )
}
