import axios, { AxiosPromise } from "axios"
import { PriceData } from "../interfaces/PriceData";
import { useQuery } from "@tanstack/react-query";

const API_URL = "http://localhost:8080/"

const fetchData = async ():AxiosPromise<PriceData[]> => {
  const response = axios.get(API_URL + "price");
  return response;
}

export function usePriceData() {
  const query = useQuery({
    queryFn: fetchData,
    queryKey: ['price-data'],
    retry: 2
  })

  return {
    ...query,
    priceData: query.data?.data
  }
}