import { Container } from './styles';
import Header from '../../templates/Header';
import { ProductPageContext } from '../../../contexts/ProductPageContext';
import ProductCardGrid from '../../templates/ProductCardGrid';
import { useProductData } from '../../../hooks/useProductData';
import { useState } from 'react';
import ProductAssociatedMarketsModal from '../../templates/ProductAssociatedMarketsModal';

export function ProductPage() {
  const { productData, isLoading, error } = useProductData();
  const [ productModalIsOpen, setProductModalIsOpen ] = useState(false);
  const [ productModalProductId ,setProductModalProductId] = useState<number | undefined>(undefined)
  
  
  if (isLoading) return <p>Loading...</p>;
  if (error) return <p>Error loading data</p>;
  

  return (
    <Container>
      <Header />
      <ProductPageContext.Provider value={{ productData, productModalIsOpen, setProductModalIsOpen, setProductModalProductId, productModalProductId }}>
        <ProductCardGrid />
        { productModalIsOpen && <ProductAssociatedMarketsModal />}
      </ProductPageContext.Provider>
    </Container>
  );
}