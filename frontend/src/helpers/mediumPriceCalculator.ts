import { PriceData } from "../interfaces/PriceData";



export const MediumPriceCalculator = (productId : number | undefined, pData : PriceData[] | undefined):number => {
  
  let productCount:number = 0;
  let totalPrice:number = 0;

  
   pData?.map(PriceData => {
    if (PriceData.id_product == productId) {
      productCount += 1;
      totalPrice += PriceData.price;
    }
   }
   )
   
   return totalPrice/productCount;
}