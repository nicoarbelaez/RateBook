import "../styles/globals.css";

export const metadata = {
  title: 'Auth App',
  description: 'Authentication with Login and Register',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className="bg-gray-100 text-gray-800">{children}</body>
    </html>
  );
}
