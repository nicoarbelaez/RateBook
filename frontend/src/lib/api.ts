interface AuthResponse {
  token: string;
  user: {
    id: number;
    username: string;
    email: string;
  };
}

export async function login(username: string, password: string): Promise<AuthResponse> {
  const res = await fetch("http://localhost:8080/api/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  });

  if (!res.ok) {
    throw new Error("Login failed");
  }

  const response: AuthResponse = await res.json();
  return response;
}

export async function register(username: string, password: string): Promise<AuthResponse> {
  const res = await fetch("http://localhost:8080/api/auth/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  });

  if (!res.ok) {
    throw new Error("Registration failed");
  }

  const response: AuthResponse = await res.json();
  return response;
}
