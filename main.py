def main():
    data = read_rcv1_v2()
    print_doc_cat(data)

def read_rcv1_v2():
    data = {}

    with open("rcv1-v2.topics.qrels.txt", 'r') as file:
        for line in file:
            parts = line.split()
            if len(parts) >= 2:
                category = parts[0]
                doc_id = parts[1]

                if doc_id not in data:
                    data[doc_id] = []  # Store categories for each document ID
                data[doc_id].append(category)
    return data

def print_doc_cat(data):
    for doc_id, categories in data.items():
        if categories:
            categories_str = ', '.join(categories)  # Join categories for the document
            print(f"Document ID: {doc_id}, Categories: {categories_str}")


if __name__ == "__main__":
    main()