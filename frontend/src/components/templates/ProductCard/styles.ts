import styled from 'styled-components';

export const Container = styled.div`

  cursor: pointer;
  display: flex;
  padding: 15px 15px;
  margin-bottom: 10px;
  

  background-color: rgba(0,0,0,0.1);
  img {
    max-width: 100px;
    border-radius: 35%;
  }

  .info-container {
    margin-left: 20px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;

    h2 {
      color: var(--color-5);
    }

    p {
      color: var(--color-2);
    }
  }
`;
