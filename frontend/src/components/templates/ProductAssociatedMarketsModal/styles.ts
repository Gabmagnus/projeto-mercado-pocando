import styled from 'styled-components';

export const Container = styled.div`
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  max-width: 400px;
  margin: 20px auto;
`;

export const MarketList = styled.ul`
  margin-top: 10px;
  list-style-type: none;
  padding: 0;
`;

export const MarketItem = styled.li`
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #eee;
  border-radius: 4px;
  background-color: #fff;

  p {
    margin: 5px 0;
  }
`;
