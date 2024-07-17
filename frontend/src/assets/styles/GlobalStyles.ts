import { createGlobalStyle } from "styled-components";

export const GlobalStyles = createGlobalStyle`

  :root{
      --color-white: #fff;
      --color-1: #333333;
      --color-2: #939196ff;
      --color-3: #c0fdfbff;
      --color-4: #fadf7fff;
      --color-5: #ff3c38ff;

      --jet: #333333ff;
      --taupe-gray: #939196ff;
      --celeste: #c0fdfbff;
      --jasmine: #fadf7fff;
      --vermilion: #ff3c38ff;
    }

    *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    *, input, button {
      font-family: 'Roboto';
    }

    html, body {
      background-color: var(--color-1);
    }

`