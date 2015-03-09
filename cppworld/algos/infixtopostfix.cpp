//#include <iostream>
//
//#include <stack>
//
//#include <string>
//
//using namespace std;
//
//
//
//
//
//// Simply determine if character is one of the four standard operators.
//
//bool isOperator(char character) {
//
//	if (character == '+' || character == '-' || character == '*' || character == '/') {
//
//		return true;
//
//	}
//
//	return false;
//
//}
//
//
//
//
//
//// If the character is not an operator or a parenthesis, then it is assumed to be an operand.
//
//bool isOperand(char character) {
//
//	if (!isOperator(character) && character != '(' && character != ')') {
//
//		return true;
//
//	}
//
//	return false;
//
//}
//
//
//
//
//
//// Compare operator precedence of main operators.
//
//// Return 0 if equal, -1 if op2 is less than op1, and 1 if op2 is greater than op1.
//
//int compareOperators(char op1, char op2) {
//
//	if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) { return -1; }
//
//	else if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) { return 1; }
//
//	return 0;
//
//}
//
//bool prcd(char op1, char op2)
//{
//	if(op1 == '+' && op2 == '*')
//		return false;
//	else if(op1 == '*' && op2 == '+')
//		return true;
//	else if(op1 == '-' && op2 == '*')
//		return false;
//	else if(op1 == '*' && op2 == '-')
//		return true;
//	else if(op1 == '$' && op2 == '*')
//		return true;
//	else if(op1 == '*' && op2 == '$')
//		return false;
//	else if(op1 == '$' && op2 == '+')
//		return true;
//	else if(op1 == '$' && op2 == '-')
//		return true;
//	return false;
//}
//
//string postToIn(string post)
//{
//	string tmp = "";
//	string infix = "";
//	typedef struct Operand
//	{
//		string str;
//		char oper;
//	}Operand;
//	typedef stack<Operand> OpndStk;
//	OpndStk os;
//	for(unsigned int i=0; i<post.size(); i++)
//	{
//		Operand o;
//		if(isalpha(post[i]))
//		{
//			o.str = "";
//			o.str += post[i];
//			o.oper = ' ';
//			os.push(o);
//			continue;
//		}
//		else
//		{
//			Operand op2 = os.top();
//			os.pop();
//			Operand op1 = os.top();
//			os.pop();
//			if( op2.oper != ' ')
//			{
//				if(prcd(post[i],op2.oper))
//				{
//					op2.str.insert(0,"(");
//					op2.str.append(")");
//				}
//			}
//			if( op1.oper != ' ')
//			{
//				if(prcd(post[i],op1.oper))
//				{
//					op1.str.insert(0,"(");
//					op1.str.append(")");
//				}
//			}
//			tmp = op1.str+post[i]+op2.str;
//			Operand t;
//			t.str = tmp;
//			t.oper = post[i];
//			os.push(t);
//		}
//	}
//	infix = os.top().str;
//	os.pop();
//	return infix;
//}
//
//string postToIn_mine(string post)
//{
//	stack<char> st;
//	char ch = 0;
//	string infix;
//
//	for (unsigned short i = 0; i < post.size(); i++)
//	{
//		ch = post[i];
//		if (isOperand(ch))
//		{
//			st.push(ch);
//		}
//		else if (isOperator(ch))
//		{
//			if (st.size() < 2)
//			{
//				cout << "\nwrong postfix expression";
//				return "\0";
//			}
//			else
//			{
//				for (short i = 0; i < 2; i++)
//				{
//					infix += st.top();
//					st.pop();
//				}
//				for (unsigned short i = 0; i < infix.size(); i++)
//				{
//					st.push(infix[i]);
//				}
//			}
//		}
//	}
//	return infix;
//}
//int main_infixtopostfix()
//
//{
//
//	// Empty character stack and blank postfix string.
//
//	stack<char> opStack;
//
//	string postFixString = "";
//	char input[100];
//	// Collect input
//	cout << "Enter an expression: ";
//	cin >> input;
//	// Get a pointer to our character array.
//	char *cPtr = input;
//	// Loop through the array (one character at a time) until we reach the end of the string.
//	while (*cPtr != '\0') {
//		// If operand, simply add it to our postfix string.
//		// If it is an operator, pop operators off our stack until it is empty, an open parenthesis or an operator with less than or equal precedence.
//		if (isOperand(*cPtr)) { postFixString += *cPtr; }
//		else if (isOperator(*cPtr)) {
//			while (!opStack.empty() && opStack.top() != '(' && compareOperators(opStack.top(), *cPtr) <= 0) {
//				postFixString += opStack.top();
//				opStack.pop();
//			}
//			opStack.push(*cPtr);
//		}
//		// Simply push all open parenthesis onto our stack
//		// When we reach a closing one, start popping off operators until we run into the opening parenthesis.
//		else if (*cPtr == '(') { opStack.push(*cPtr); }
//		else if (*cPtr == ')') {
//			while (!opStack.empty()) {
//				if (opStack.top() == '(') { opStack.pop(); break; }
//				postFixString += opStack.top();
//				opStack.pop();
//			}
//		}
//		// Advance our pointer to next character in string.
//		cPtr++;
//	}
//	// After the input expression has been ran through, if there is any remaining operators left on the stack
//	// pop them off and put them onto the postfix string.
//	while (!opStack.empty()) {
//		postFixString += opStack.top();
//		opStack.pop();
//	}
//	// Show the postfix string at the end.
//	cout << "Postfix is: " << postFixString << endl;
//	cout<<"\ninfix string is "<<postToIn_mine(postFixString);
//	return 0;
//}
//
