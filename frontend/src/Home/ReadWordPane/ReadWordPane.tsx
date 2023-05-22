import { Box, Center } from "@chakra-ui/react";
import { Manuscript } from "types";

type Props = {
  manuscript: Manuscript | undefined;
  phraseIndex: number;
};

function ReadWordPane({manuscript,phraseIndex}:Props) {
  return (
    <Center h="100%" w="100vw">
        <Box fontSize="3em">
            {manuscript?.phrase[phraseIndex]}
        </Box>
    </Center>
  );
}

export { ReadWordPane };
