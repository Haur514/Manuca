import { Box, Text } from "@chakra-ui/react";
import React from "react";
import { Manuscript } from "types";

type Props = {
  manuscript: Manuscript | undefined;
  phraseIndex: number;
};

function FullTextPane({ manuscript, phraseIndex }: Props) {
  console.log(phraseIndex);

  function bgColor(i: number, phraseIndex: number) {
    if (i === phraseIndex) {
      return "#9effce";
    } else {
      return "";
    }
  }

  return (
    <Box w="calc(100vw - min(30vw,30em))">
      <Text>本文</Text>
      {manuscript?.phrase.map((text: string, i: number) => {
        return (
          // eslint-disable-next-line react/no-array-index-key
          <Box as="span" key={i} bg={bgColor(i, phraseIndex)}>
            {text}
          </Box>
        );
      })}
    </Box>
  );
}

export { FullTextPane };
