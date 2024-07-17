import { Dispatch, SetStateAction } from "react";
import { ProductData } from "./ProductData";

export interface ProductPageContextType {
  productData: ProductData[] | undefined;
  setProductModalIsOpen: Dispatch<SetStateAction<boolean>>;
  setProductModalProductId: Dispatch<SetStateAction<number | undefined>>;
  productModalIsOpen: boolean;
  productModalProductId: number | undefined;
}