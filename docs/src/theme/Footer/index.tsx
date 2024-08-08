import React from 'react';
import SocialLinks from '../Link/SocialLinks';
import socialLinks from '../Link/link-data/social-links';
import Hyperlinks from '../Link/Hyperlinks';
import hyperlinks from '../Link/link-data/hyperlinks';
import Copyright from '../Link/Copyright';


const Footer: React.FC = () => {
  return (
    <footer className="footer">
      <div className="container">
        <div className="row">
          <div className="links col">
            <SocialLinks socialLinks={socialLinks} />
            <Hyperlinks hyperlinks={hyperlinks} />
          </div>
          <div className="col col--3"></div>
        </div>
        <div className="row">
          <Copyright />
          <div className="col col--3"></div>
        </div>
      </div>
    </footer>
  );
}
export default React.memo(Footer);
