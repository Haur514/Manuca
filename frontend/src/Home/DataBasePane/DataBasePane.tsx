import { Box, Button, Center } from "@chakra-ui/react";
import React from "react";
import { Manuscript } from "types";

type Props = {
  manuscripts: Manuscript[] | undefined;
  setSelectedManuscriptId: (arg0: number) => void;
};
function DataBasePane({ manuscripts, setSelectedManuscriptId }: Props) {
  return (
    <Box bg="#313131" w="min(30%,20em)">
      {manuscripts?.map((manuscript) => {
        return (
          <Box key={manuscript.id} h="3em" w="calc(100%-1em)">
            <Center>
              <Button
                key={manuscript.id}
                w="100%"
                h="100%"
                bg="#f1f1f1"
                p=".5em"
                m=".5em"
                borderRadius=".5em"
                onClick={() => setSelectedManuscriptId(manuscript.id)}
              >
                No Title {manuscript.id}
              </Button>
            </Center>
          </Box>
        );
      })}
    </Box>
  );
}

export { DataBasePane };
