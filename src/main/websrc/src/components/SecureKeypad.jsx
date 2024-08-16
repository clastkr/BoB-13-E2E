import '../style/keypad.css'

const columnCount = 3;  // 가로 3칸
const rowCount = 4;     // 세로 4칸

export default function SecureKeypad({ keypad, onKeyPressed }) {
    return (
        <>
            <table className="table-style">
                <tbody>
                    {Array.from({ length: rowCount }).map((_, rowIdx) => (
                        <tr key={rowIdx}>
                            {Array.from({ length: columnCount }).map((_, columnIdx) => {
                                const idx = rowIdx * columnCount + columnIdx;

                                // idx가 keypad 배열 범위를 넘지 않도록 확인
                                if (idx >= keypad.length) {
                                    return <td key={columnIdx} className="td-style"></td>;
                                }

                                return <td key={columnIdx} className="td-style">
                                    <button className="button-style" onClick={() => onKeyPressed(idx)}>
                                        <img className="number-style" src={`data:image/png;base64,${keypad[idx].imageData}`} alt={`keypad-${idx}`} />
                                    </button>
                                </td>
                            })}
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
}
