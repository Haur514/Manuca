import { useEffect, useState } from "react";
import { DataBasePane } from "./DataBasePane/DataBasePane";
import { FullTextPane } from "./FullTextPane/FullTextPane";
import { ReadWordPane } from "./ReadWordPane/ReadWordPane";

import { Box, Flex } from '@chakra-ui/react'
import { Manuscript } from "types";
import { Backend } from "util/Backend";
import { useKey } from "react-use";

function HomeParent() {

  const [manuscripts,setManuscripts] = useState<Manuscript[]>([]);
  const [phraseIndex,setPhraseIndex] = useState<number>(0);

  const [selectedManuscripts,setSelectedManuscripts] = useState<Manuscript>();
  const [selectedManuscriptId,setSelectedManuscriptId] = useState<number>(0);

  async function fetchManuscriptList() {
    const manuscriptList = await Backend.getManuscriptList();

    if (manuscriptList === null) {
      console.error("fetchMessagesList: failed");
      return;
    }
    setManuscripts(manuscriptList);
  }

  function findManuscriptById(id: number){
    const candidate = manuscripts.filter((m) => m.id === id);
    if(candidate === null){
      setSelectedManuscripts(undefined);
    }else{
      setSelectedManuscripts(candidate[0]);
    }
  }
  function jouyo(phraseIndex:number,manuscript:Manuscript | undefined){
    const phraseLength = manuscript?.phrase.length;
    if(typeof phraseLength === "undefined"){
      return 0;
    }
    let ret = phraseIndex % phraseLength;
    if(ret < 0){
      ret += phraseLength;
    }
    return ret;
  }
  function phraseIndexIncrease(){
    setPhraseIndex((phraseIndex) => ++phraseIndex);
  }

  function phraseIndexDecrease(){
    setPhraseIndex((phraseIndex) => --phraseIndex);
  }


  useKey("ArrowRight",phraseIndexIncrease);
  useKey("ArrowLeft",phraseIndexDecrease);


  useEffect(() => {
    fetchManuscriptList();
  },[]);

  useEffect(() => {
    findManuscriptById(selectedManuscriptId);
  },[manuscripts,selectedManuscriptId])

  useEffect(() => {
    setPhraseIndex((phraseIndex) => jouyo(phraseIndex,selectedManuscripts))
  },[phraseIndex])

  useEffect(() => {
    setPhraseIndex(0);
  },[selectedManuscriptId])

  return (
    <Box h="100vh">
      <Flex h="8em" w="100vw">
      <ReadWordPane manuscript={selectedManuscripts} phraseIndex={phraseIndex}/>
      </Flex>
      <Flex color="black" h="calc(100% - 8em)" w="100vw"> 
        <DataBasePane manuscripts={manuscripts} setSelectedManuscriptId={setSelectedManuscriptId}/>
        <FullTextPane manuscript={selectedManuscripts} phraseIndex={phraseIndex}/>
      </Flex>
    </Box>
  );
}

export { HomeParent };
