public class HuffmanDecoder {


    /**
     * Program reads in a compressed .huf file, decodes the compressed file
     * and writes the original file back to a new .txt file good as new.
     * @param args
     */
    public static void main(String[] args) {

        //1: Read the compressed Huffman coding trie.
        ObjectReader or = new ObjectReader(args[0]);
        Object bt = or.readObject();
        BinaryTrie trie = (BinaryTrie) bt;

        //3: Read the massive bit sequence corresponding to the original txt.
        Object mbs = or.readObject();  //Read second object from file.
        BitSequence massiveBitSequence = (BitSequence) mbs;

        /*
        4: Repeat until there are no more symbols:
            4a: Perform a longest prefix match on the massive sequence.
            4b: Record the symbol in some data structure.
            4c: Create a new bit sequence containing the remaining unmatched bits.
        */

        Match m1 = trie.longestPrefixMatch(massiveBitSequence);
        System.out.println(m1.getSymbol());
    }


    //Utility method for HuffmanDecoder.
    public static void writeCharArray(String filename, char[] chars) {
        BinaryOut out = new BinaryOut(filename);
        for (char c : chars) {
            out.write(c);
        }
        out.close();
    }


}