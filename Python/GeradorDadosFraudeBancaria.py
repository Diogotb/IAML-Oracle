import pandas as pd
import numpy as np

# Gerar novos dados aleatórios
np.random.seed(42)  # Para reprodutibilidade

transaction_amount = np.random.randint(50, 1000, size=1000)
transaction_location = np.random.randint(1, 4, size=1000)
transaction_time = np.random.randint(0, 24, size=1000)
is_fraud = np.random.randint(0, 2, size=1000)

# Criar um DataFrame com os novos dados
new_data = {
    "transaction_amount": transaction_amount,
    "transaction_location": transaction_location,
    "transaction_time": transaction_time,
    "is_fraud": is_fraud
}

df_new = pd.DataFrame(new_data)

# Salvar em um arquivo CSV
csv_path_new = 'new_transaction_data.csv'
df_new.to_csv(csv_path_new, index=False)

print(f"Novo arquivo CSV salvo como {csv_path_new}")
