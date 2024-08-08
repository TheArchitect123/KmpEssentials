import React from 'react';
import { Card, CardProps } from './Card';

interface CardSectionProps {
  cards: CardProps[]
}

const CardSection: React.FC<CardSectionProps> = ({ cards }) => {
  return (
    <div className="cards">
      {cards.map((card, index) => {
        return (
          <Card
            key={index}
            href={card.href}
            lightSVG={card.lightSVG}
            darkSVG={card.darkSVG}
            header={card.header}
            summary={card.summary}
          />  
        )
      })}
    </div>
  )
}

export default CardSection;
