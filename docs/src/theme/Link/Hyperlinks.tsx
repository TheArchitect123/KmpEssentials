import React from 'react';
import { Hyperlink, HyperlinkProps } from './Hyperlink';

interface HyperlinkItems {
  hyperlinks: HyperlinkProps[];
}

const Hyperlinks: React.FC<HyperlinkItems> = ({ hyperlinks }) => {
  return (
    <div className="hyperlinks">
      {hyperlinks.map((hyperlink) => {
        return (
          <Hyperlink
            href={hyperlink.href}
            innerHTML={hyperlink.innerHTML}
          />  
        )
      })}
    </div>
  )
}

export default Hyperlinks;
