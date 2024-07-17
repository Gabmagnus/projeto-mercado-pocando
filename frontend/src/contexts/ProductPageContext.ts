import { createContext } from "react";
import { ProductPageContextType } from "../interfaces/ProductPageContextData";

export const ProductPageContext = createContext<ProductPageContextType>({
  productData: [],
  setProductModalIsOpen: () => {},
  setProductModalProductId: () => {},
  productModalIsOpen: false,
  productModalProductId: undefined,
  
}); 