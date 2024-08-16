"use client";

import React, {useEffect} from 'react';
import useSecureKeypad from '../hooks/useSecureKeypad';
import SecureKeypad from "../components/SecureKeypad";
import KeypadUserInput from "../components/KeypadUserInput.jsx";

export default function Page() {
  const { states, actions } = useSecureKeypad();

  useEffect(() => {
      actions.getSecureKeypad();
  }, []);

  if (states.keypad === null) {
    return (
      <div>
        ...isLoading...
      </div>
    )
  } else {
    return (
      <div>
        <KeypadUserInput userInput={states.userInput}/>
        <SecureKeypad keypad={states.keypad} onKeyPressed={actions.onKeyPressed}/>
      </div>
    );
  }
}
