import '../style/keypad.css'
import {passwordCount} from "@/hooks/useSecureKeypad.jsx";

export default function KeypadUserInput({ userInput }) {
    return (
        <>
            <div className="input-group-style">
                {Array.from({ length: passwordCount }, (_, idx) => (
                    <div key={idx} className={`input-char-style ${idx < userInput?.length ? 'active' : ''}`}></div>
                ))}
            </div>
        </>
    );
}
