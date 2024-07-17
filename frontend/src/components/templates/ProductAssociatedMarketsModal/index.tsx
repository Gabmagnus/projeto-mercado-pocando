import React, { useContext } from 'react';
import { Container, MarketList, MarketItem } from './styles'; // Certifique-se de importar estilos adequados
import { ProductPageContext } from '../../../contexts/ProductPageContext';
import { useProductData } from '../../../hooks/useProductData';
import { useMarketData } from '../../../hooks/useMarketData';
import { usePriceData } from '../../../hooks/usePriceData';

const ProductAssociatedMarketsModal: React.FC = () => {
  const { productData } = useProductData();
  const { marketData } = useMarketData();
  const { productModalProductId } = useContext(ProductPageContext);
  const { priceData } = usePriceData();

  // Encontrar o produto correto com base no productModalProductId
  const product = productData.find(data => data.id === productModalProductId);

  // Encontrar mercados onde o produto aparece
  const marketsForProduct = marketData?.filter(market =>
    priceData?.some(price => price.id_product === productModalProductId && price.id_market === market.id)
  );

  return (
    <Container>
      {product ? (
        <>
          <h2>{product.title}</h2>
          <MarketList>
            {marketsForProduct?.map(market => {
              // Encontrar o preço do produto neste mercado
              const productPrice = priceData?.find(price => price.id_product === productModalProductId && price.id_market === market.id);
              return (
                <MarketItem key={market.id}>
                  <p>{market.title}</p>
                  {productPrice ? <p>Preço: R$ {productPrice.price.toFixed(2)}</p> : <p>Preço não disponível</p>}
                </MarketItem>
              );
            })}
          </MarketList>
        </>
      ) : (
        <p>Produto não encontrado</p>
      )}
    </Container>
  );
};

export default ProductAssociatedMarketsModal;
