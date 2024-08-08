import React from 'react';
import ThemedImage from '@theme/ThemedImage';

export interface CardProps {
  href: string,
  lightSVG: string,
  darkSVG: string,
  header: string,
  summary: string
}

export const Card: React.FC<CardProps> = ({
  href, lightSVG, darkSVG, header, summary
}) => {
  return (
    <a href={href}>
      <ThemedImage sources={{
        light: lightSVG,
        dark: darkSVG
      }} />
      <div className="text-container">
        <h2>{header}</h2>
        <p>{summary}</p>
      </div>
    </a>
  )
}
