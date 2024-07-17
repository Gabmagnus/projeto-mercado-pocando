// components/ProductCardGrid.tsx
import React, { useContext } from 'react';
import { Container } from './styles';
import { ProductPageContext } from '../../../contexts/ProductPageContext';
import ProductCard from '../ProductCard';
import { MediumPriceCalculator } from '../../../helpers/mediumPriceCalculator';
import { usePriceData } from '../../../hooks/usePriceData';

const ProductCardGrid: React.FC = () => {
  const {priceData} = usePriceData();

  const context = useContext(ProductPageContext);
  if (!context)
    return null; 
  const { productData, setProductModalIsOpen, setProductModalProductId, productModalIsOpen } = context;

  const setModalOpen = (productId: number | undefined):void => {
    if (productModalIsOpen) {
      console.log("modal ja esta aberto!");
      return;
    }
    setProductModalIsOpen(true)
    setProductModalProductId(productId);
    console.log("modal aberto!");
      
  }
  return (
    <Container>
      {productData?.map(data => (
        <ProductCard
          key={data.id}
          title={data.title}
          image={data.image}
          category={data.category}
          mediumPrice={MediumPriceCalculator(data.id, priceData)} // Assumindo que MediumPriceCalculator está definido
          clickAction={() => setModalOpen(data.id)}
        />
      ))}
    </Container>
  );
};

export default ProductCardGrid;