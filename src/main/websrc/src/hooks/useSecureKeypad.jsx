"use client";

import {useEffect, useMemo, useState} from 'react';
import axios from "axios";
import {JSEncrypt} from "jsencrypt";

export const passwordCount = 6;

export default function useSecureKeypad() {
  const [keypad, setKeypad] = useState(null);
  const [userInput, setUserInput] = useState([]);

  const getSecureKeypad = () => {
    axios.get("http://localhost:8080/api/create_key").then((v) => {
      setKeypad(v.data);
    })
  }

  const onKeyPressed = (idx) => {
    if(keypad[idx].hashData === '') return;
    setUserInput((v) => [...v, keypad[idx]]);
  }

  const sendUserInput = () => {
    const hash = userInput.map((v) => v.hashData).join('');
    alert(hash);
    window.location.reload();
  }

  useEffect(() => {
    if(userInput.length >= passwordCount) {
      sendUserInput();
    }
  }, [userInput]);

  return {
    states: {
      keypad,
      userInput,
    },
    actions: {
      getSecureKeypad,
      onKeyPressed,
      sendUserInput
    }
  }
}
