import axios, { AxiosPromise } from "axios"
import { MarketData } from "../interfaces/MarketData";
import { useQuery } from "@tanstack/react-query";

const API_URL = "http://localhost:8080/"

const fetchData = async ():AxiosPromise<MarketData[]> => {
  const response = axios.get(API_URL + "market");
  return response;
}

export function useMarketData() {
  const query = useQuery({
    queryFn: fetchData,
    queryKey: ['market-data'],
    retry: 2
  })

  return {
    ...query,
    marketData: query.data?.data
  }
}