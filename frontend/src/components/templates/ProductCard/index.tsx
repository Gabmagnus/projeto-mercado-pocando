import React from 'react';

import { Container } from './styles';
interface CardProps {
  title: string;
  image: string,
  category: string,
  mediumPrice: number,
  clickAction: () => void,
}

const ProductCard: React.FC<CardProps> = ({clickAction, title, image, category, mediumPrice}) => {
  
  const defaultImageFiles: string = "/src/assets/images/";

  return (
    <Container onClick={clickAction}>
      <img src={defaultImageFiles + image}  alt={title} />
      <div className="info-container">
        <h2>{title}</h2>
        <div className="price-container">
          <p>Categoria: {category}</p>
          <p>Preco Medio: {`$${mediumPrice.toFixed(2)}`}</p>
        </div>
      </div>
    </Container>
  );
}

export default ProductCard;